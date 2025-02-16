package org.itmo.Presentation.Commands.CentralBank;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
@Command(
        name="LogIn"
        descripttion="Log in as bank"
)
public class ChargeFeeNotificationCommand implements Runnable {
    @Parameters(index="0", description = "Bank ID")
    private int bankID;

    @Option(names={"-v", "--verbose"}, description="Verbose output?")
    private boolean verbose;

    public static void main(String[] args){
        new CommandLine(new LogInCommand()).execute(args);
    }

    @Override
    public void run(){
        //Some stuff
    }
}
