package com.coronagoaway;
//  Task
//        todo сообщить всем присутствующим в комнате, что о начале дезинфекции, и попросить всех свалить
//        todo разогнать всех кто не вышел после объявления
//        todo сообщить всем присутствующим в комнате, что они могут вернуться обратно

public class CoronaDesinfector {
    @InjectByType
    private Announcer announcer;
    @InjectByType
    private Policeman policeman;

    public void start(Room room){
        announcer.announce("Начинаем дезинфекцию, все вон!");
        policeman.makePeopleLeaveRoom();
        desinfect(room);
        announcer.announce("Рискните зайти обратно");
    }

    private void desinfect(Room room) {
        System.out.println("зачитывается молитва: 'корона изыди!' - молитва прочитана, вирус низвергнут в ад");
    }
}
