import javax.swing.JFrame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class Gui extends JFrame{
public  JButton bR,bC,b3;// declaro los botones
  JLabel t1;//declaro Tx
  JTextField tf;//Caja de texto
  JPanel p1;
  JTextArea ta1;
  JScrollPane scrollpane;
    public Gui(){
    super ("Test");//Construyo el padre
    this.setSize(600,400);// tamaño de la ventana
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// para que se cierre por defecto
    //this.setLayout(null);// sin layout, voy  a poner los botones donde me dá la gana
    //this.setLayout(new FlowLayout());
    this.setLayout(new BorderLayout(5,10));

    // agregamos botones
    bR=new JButton("Registrar ");//iniciamos objeto
    //bR.setBounds(10,80,100,30);//tamaño (x,y,w,t)?
    //this.add(bR);// agregamos al frame
    this.add(bR,BorderLayout.WEST);
    bC=new JButton("Consultar");//iniciamos objeto
    //bC.setBounds(10,120,100,30);//tamaño
    //this.add(bC);// agregamos al frame
    this.add(bC,BorderLayout.EAST);// agregamos al frame
    // agregamos Labels
    t1=new JLabel("Test Gui");
    //t1.setBounds(40,15,100,40);
    this.add(t1,BorderLayout.NORTH);

    //agregamos Text Field
    tf = new JTextField("Prueba Textfield");
    this.add(tf,BorderLayout.SOUTH);

    //agregamos panel
    p1 = new JPanel (new GridLayout(2,1));//le asignamos estilo borderlayout
    //2 y 3 son los espacios entralas regiones
    p1.add(bR);// agregamso los itme a cantener en el panel
    p1.add(bC);
    this.add(p1,BorderLayout.WEST);

    //Agremamos area de texto y lo contenemso en el scrollpane

    ta1 = new JTextArea();
    scrollpane=new JScrollPane(ta1);//metemos el textArea en el scrollpane
    this.add(scrollpane,BorderLayout.CENTER);

//creamos el oyente para los evento de los Botones
    Oyente a = new Oyente();
    bR.addActionListener(a);
    bC.addActionListener(a);

  this.setVisible(true);
  }
  class Oyente implements ActionListener{
    public void actionPerformed(ActionEvent e){
      if(e.getSource() == bR){
        System.out.println("Boton R");
        t1.setText("Cambio de texto");
      }
      if(e.getSource() == bC){
        System.out.println("Boton C");
        t1.setText(tf.getText());
        ta1.append("Escribiendo en el Texto Area\n");
      }
    }
  }

}
