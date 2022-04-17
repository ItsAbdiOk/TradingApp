package com.company;
import java.awt.*;
import java.awt.event.*;


public class BankingApp extends Frame{

    /*
     * We will use this to print messages to the user.
     */
    private static TextArea infoArea = new TextArea("                       Trading                        ");

    public static void print(String text){
        infoArea.setText(text);
    }

    private Agent agent;
    private Panel UserButtonsPanel;


    public void deposit ( int amount) {
        agent.deposit(amount);
        print("Successful deposit");
    }

    public void SeeInfo(){
        String text = agent.GetUserInfo();
        text += agent.SeeWallet();
        print(text);
    }



    public void Withdraw(int amount){
        agent.withdraw(amount);
    }
    public void AddStock(Stocks s){
        agent.addStock(s);
    }



    public void BuyShares ( String Stockname) {
        String found = agent.BuyShares(Stockname);
        print(found);
    }
    public void SellShares ( String Stockname) {
        String found = agent.SellShares(Stockname);
        print(found);
    }



    /**
     * This method prints the information of the User with the given index.
     */
    public void printUserInfo(){
        String text = Agent.GetUserInfo();
        print(text);
    }

    /**
     * This method takes all the necessary steps when a User is added.
     */

    public void addUser(String name){
        new Agent(name);
    };

    public BankingApp(){

        this.agent = new Agent(("Abdi"));
        this.setLayout(new FlowLayout());




        // Make this button work
        Button depositButton = new Button("Deposit");
        depositButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Prompt acp = new Prompt();

                //...

                TextField UserInputGuide2 = new TextField("Enter Deposit Amount");
                acp.add(UserInputGuide2);
                acp.addSubmitListener (new ActionListener(){
                    public void actionPerformed (ActionEvent evt) {

                        int UserAmount = Integer.parseInt (UserInputGuide2.getText());
                        deposit( UserAmount);
                    }
                });
                acp.activate();
            }
        });
        this.add(depositButton);
        // Make this button work

        // Make this button work
        Button BuyStocksButton = new Button("Buy Stocks");
        BuyStocksButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Prompt acp = new Prompt();
                //...


                //...
                TextField UserInputGuide5 = new TextField("Enter Stock Name");
                acp.add(UserInputGuide5);



                acp.addSubmitListener (new ActionListener(){
                    public void actionPerformed (ActionEvent evt) {

                        String UserSTockWantedName = UserInputGuide5.getText();
                        BuyShares(UserSTockWantedName );
                    }
                });
                acp.activate();
            }
        });
        this.add(BuyStocksButton);
        // Make this button work
        Button SellStocksButton = new Button("Sell Stocks");
        SellStocksButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Prompt acp = new Prompt();
                //...

                //...
                TextField UserInputGuide8 = new TextField("Sale Stock Name");
                acp.add(UserInputGuide8);



                acp.addSubmitListener (new ActionListener(){
                    public void actionPerformed (ActionEvent evt) {

                        String UserSTockNotWantedName = UserInputGuide8.getText();
                        SellShares(UserSTockNotWantedName);
                    }
                });
                acp.activate();
            }
        });
        this.add(SellStocksButton);
        // Make this button work
        Button WithdrawButton = new Button("Withdraw");
        WithdrawButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                Prompt acp = new Prompt();

                //...
                TextField UserInputGuide3 = new TextField("Enter User Name");
                acp.add(UserInputGuide3);

                TextField UserInputGuide4 = new TextField("Enter Withdraw Amount");
                acp.add(UserInputGuide4);
                acp.addSubmitListener (new ActionListener(){
                    public void actionPerformed (ActionEvent evt) {

                        int UserAmount = Integer.parseInt (UserInputGuide4.getText());
                        Withdraw(UserAmount);
                    }
                });
                acp.activate();
            }
        });
        this.add(WithdrawButton);

        Button portfolioButton=new Button("See portfolio");
        portfolioButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt) {
                SeeInfo();


            };
        });
        this.add(portfolioButton);


        // Output console
        infoArea.setEditable(false);
        this.add(infoArea);

        // User button panel
        // Uncomment for R3
        UserButtonsPanel = new Panel();
        UserButtonsPanel.setLayout(new GridLayout(0,3));
        UserButtonsPanel.setVisible(true);
        this.add(UserButtonsPanel);


        // This is just so the X button closes our app
        WindowCloser wc = new WindowCloser();
        this.addWindowListener(wc);




        this.setSize(500,500);// Self explanatory
        this.setLocationRelativeTo(null); // Centers the window on the screen
        this.setVisible(true);// Self explanatory

    }
    public static void main(String[] args) {
        System.out.println("Hello World");

        new BankingApp();
    }

}
