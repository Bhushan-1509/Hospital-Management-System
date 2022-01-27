import javax.swing.*;

public class InitialLoading extends JFrame {
    JProgressBar jb;
    static JFrame load;
    public InitialLoading() throws InterruptedException {

        setSize(600,300);
        setLayout(null);
        setLocationRelativeTo(null);
        setVisible(true);
        jb = new JProgressBar(0,3000);
        add(jb);
        loadingBar();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public void loadingBar() throws InterruptedException {

        jb.setBounds(160,150,280,30);
        jb.setValue(0);
        jb.setStringPainted(true);

//        loading of progressbar
        int i = 0;
        while(i <= 3000){
            jb.setValue(i);
            i+=50;
            Thread.sleep(50);
        }

    }

    public static void main(String[] args) throws Exception {

        load = new InitialLoading();
        load.setVisible(true);
//        new Main();
        load.dispose();
        load = new Main();
        new PlayAudio();

    }


}
