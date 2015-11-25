package ru.saendra.testtask;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Saendra on 11/23/2015.
 */
public class ProcessData {
    private ArrayList<int[]> references;                                            // Массив цепочек зацикленных связей между сущностями.

    public void FindReferences (HashMap<Integer, TestEntity> testEntities) {
        int[] tempRef, circRef;                                                     // Временные массивы с цепочками связей между сущностями.
        int idRef;                                                                  // ID сущности, на которую ссылается исследуемая в данный момент.
        references = new ArrayList();
        Boolean repeat;                                                             // Индикатор повторного использования ID, уже участвующего в зацикленной связи.
        for(Map.Entry<Integer, TestEntity> te : testEntities.entrySet()) {          // Этот цикл перебирает все сущности в списке и устанавливает, какие из них участвуют в зацикленных связях.
            repeat = false;
            for(int[] reference : references) {                                     // Этот цикл проверяет текущую сущность на наличие в уже добавленных цепочках.
                for(int i=0; i<reference.length; i++) {
                    if(te.getKey() == reference[i]) {
                        repeat = true;
                        break;
                    }
                }
                if(repeat) {
                    break;
                }
            }
            if(repeat){
                continue;                                                           // Переход к следующей сущности, если текущая уже участвовала в цепочках ранее.
            }
            tempRef = new int[testEntities.size()];                                 // Инициализация временного массива для хранения цепочки связей.
            tempRef[0] = te.getValue().getId();                                     // Добавление первого элемента - ID текущей сущности.
            int refIndex = 0;                                                       // Индекс исследуемой в данный момент сущности.
            idRef = te.getValue().getIdRef();                                       // Получение ID сущности, связанной с исследуемой в данный момент.
            for(int i=0; i<testEntities.size(); i++) {                              // Этот цикл добавляет в цепочку новые элементы.
                for(int[] reference : references) {                                 // Этот цикл проверяет сущность на наличие в уже добавленных цепочках.
                    for(int j=0; j<reference.length; j++) {
                        if(idRef == reference[i]) {
                            repeat = true;
                            break;
                        }
                    }
                    if(repeat) {
                        break;
                    }
                }
                if(repeat) {
                    break;                                                          // Составление цепочки отменяется, если элемент уже участвует в других цепочках.
                }
                refIndex++;
                tempRef[refIndex] = idRef;                                          // Присвоение следующему элементу массива значения ID сущности, связанной с исследуемой в текущий момент.
                for(int j=0; j<refIndex; j++) {                                         // Проверка временного массива на наличие ID, равного тому, с которым связан исследуемый элемент.
                    if(tempRef[j]==idRef) {
                        circRef = new int[refIndex + 1 - j];                        // Инициализация временного массива, в который будут занесены ID сущностей с зациленной связью в порядке связи.
                        for(int k=0; k<circRef.length; k++) {
                            circRef[k] = tempRef[k+j];
                        }
                        references.add(circRef);                                    // Добавление цепочки в список.
                        repeat = true;
                        break;
                    }
                }
                if(repeat) {
                    break;                                                          // Переход к следующей сущности в списке.
                }
                try {
                    idRef = testEntities.get(idRef).getIdRef();                     // Переход к сущности, с которой связана исследовавшаяся до этого.
                }
                catch (Exception ex) {
                    break;                                                          // Или конец составления этой цепочки, если такой сущности нет.
                }
            }
        }
    }

    public ArrayList<int[]> getReferences() {
        return references;
    }
}
