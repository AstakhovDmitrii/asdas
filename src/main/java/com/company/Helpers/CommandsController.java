package com.company.Helpers;

import com.company.Command;
import com.company.Commands.Exist;
import com.company.Main;
import org.reflections.Reflections;

import java.util.ArrayList;

public class CommandsController {
    private ArrayList<Command> commands = new ArrayList<>();

    public CommandsController() {
        try {
            for (Class<? extends Command> class1 : (new Reflections("com.company.Commands")).getSubTypesOf(Command.class)) {// �������� ��� ������ ����������� �� command
                if(class1 != Exist.class) {
                    commands.add(class1.getConstructor().newInstance());// ���������
                }
            }
        }
        catch (Exception e){
            Main.Logger.error("�� ��� ������� ����������� �����");
        }
    }
    private Command Get(int ind){
        return commands.get(ind);
    }

    public ArrayList<Command> getCommands() {
        return commands;
    }
}
