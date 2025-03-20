package paquete;


import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import bbdd.ConexionBD;
import bbdd.SqlJesuitas;

public class Jesuitas implements ActionListener{

		JFrame jfrFormulario;
		JPanel jpnPrincipal;
		JPanel jpnPrincipal2;
		JLabel jlb1;
		JLabel jlbImagen1;
		JLabel jlb2;
		JLabel jlb3;
		JLabel jlb4;
		JLabel jlb5;
		JLabel jlb6;
		JTextField jtxt1;
		JTextField jtxt2;
		JTextField jtxt3;
		JTextField jtxt4;
		JTextField jtxt5;
		JButton enviar;
		
		//Conexion
		ConexionBD obj;
		SqlJesuitas objJesuitas;
		
	
	public Jesuitas() {
		// TODO Auto-generated constructor stub
		obj = new ConexionBD();
		objJesuitas = new SqlJesuitas(obj);
		
		//FORMULARIO
		jfrFormulario=new JFrame();
		jfrFormulario.setSize(500,500);
		jfrFormulario.setTitle("Jesuitas");
		jfrFormulario.setLayout(null);
		jfrFormulario.setLocationRelativeTo(null);
		jfrFormulario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PANEL 
		jpnPrincipal= new JPanel();
		jpnPrincipal.setSize(500,500);
		jpnPrincipal.setLayout(null);
		jfrFormulario.add(jpnPrincipal);	
		
		//PANEL2
		jpnPrincipal2= new JPanel();
		jpnPrincipal2.setBounds(40, 40, 400, 400);
		jpnPrincipal2.setBackground(new Color(255,255,255,150));
		jpnPrincipal2.setLayout(null);
		jpnPrincipal.add(jpnPrincipal2);	
		
		//LABEL 1
		jlb1 = new JLabel();
		jlb1.setText("Jesuitas: ");
		jlb1.setBounds(100, 50, 80, 30);
		jpnPrincipal2.add(jlb1);
		
		//LABEL 2
		
		jlb2 = new JLabel();
		jlb2.setText("Nombre Alumno : ");
		jlb2.setBounds(60, 90, 190, 30);
		jpnPrincipal2.add(jlb2);
		
		//LABEL TITULO
		
		jlb3 = new JLabel("FORMULARIO JESUITAS");
		jlb3.setBounds(130, 10, 300, 30);
		jpnPrincipal2.add(jlb3);
		
		//TEXTFIELD 1
		jtxt1= new JTextField();
		jtxt1.setBounds(170, 50, 130, 30);
		jpnPrincipal2.add(jtxt1);
		
		//TEXTFIELD 2
		jtxt2= new JTextField();
		jtxt2.setBounds(170, 90, 130, 30);
		jpnPrincipal2.add(jtxt2);
		
		//TEXTFIELD 3
		jtxt3= new JTextField();
		jtxt3.setBounds(140, 130, 130, 30);
		jpnPrincipal2.add(jtxt3);
		
		//IMAGEN
		JLabel jlbImagen1= new JLabel(new ImageIcon(Jesuitas.class.getResource("/imagenes/caliz.jpg")));
		jlbImagen1.setBounds(0, 0, 500, 500);
		jpnPrincipal.add(jlbImagen1);
		
		//LABEL 4
		jlb4 = new JLabel();
		jlb4.setText("Código: ");
		jlb4.setBounds(90, 130, 80, 30);
		jpnPrincipal2.add(jlb4);
		
		//BOTON ENVIAR
		enviar= new JButton();
		enviar.setText("Enviar");
		enviar.setBounds(170, 360, 80, 30);
		enviar.addActionListener(this);
		jpnPrincipal2.add(enviar);
		
		//LABEL 5
		jlb5 = new JLabel();
		jlb5.setText("Firma En Español ");
		jlb5.setBounds(40, 180, 130, 30);
		jpnPrincipal2.add(jlb5);
		
		//LABEL 6
		jlb6 = new JLabel();
		jlb6.setText("Firma En Inglés ");
		jlb6.setBounds(240, 180, 130, 30);
		jpnPrincipal2.add(jlb6);
		
		//TEXTFIELD 4
		jtxt4= new JTextField();
		jtxt4.setBounds(30, 220, 130, 80);
		jpnPrincipal2.add(jtxt4);
		
		//TEXTFIELD 4
		jtxt5= new JTextField();
		jtxt5.setBounds(230, 220, 130, 80);
		jpnPrincipal2.add(jtxt5);
		
		//VISUALIZAR FORMULARIO
		jfrFormulario.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			new Jesuitas();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==enviar) Ienviar();
	}
	
	public void Ienviar() {

		   objJesuitas.insertarFila(jtxt1.getText(), jtxt2.getText(), jtxt3.getText(), jtxt4.getText(), jtxt5.getText());

		   jtxt1.setText("");
		   jtxt2.setText("");
		   jtxt3.setText("");
		   jtxt4.setText("");
		   jtxt5.setText("");

	   }

}


