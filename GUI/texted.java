import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class texted extends JFrame {

	private JPanel contentPane;
	private JTextField text;
	private JButton btnB;
	private JButton c;
	private JButton d;
	private JButton f;
	private JButton g;
	private JButton h;
	private JButton i;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					texted frame = new texted();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public texted() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 800, 700);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		text = new JTextField();
		text.setBounds(10, 24, 713, 45);
		contentPane.add(text);
		text.setColumns(10);
		
		JButton a = new JButton("A");
		a.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		a.setBounds(10, 91, 100, 74);
		contentPane.add(a);
		
		JButton b = new JButton("B");
		b.setBounds(107, 91, 106, 74);
		contentPane.add(b);
		
		c = new JButton("C");
		c.setBounds(209, 91, 113, 74);
		contentPane.add(c);
		
		d = new JButton("D");
		d.setBounds(318, 91, 113, 74);
		contentPane.add(d);
		
		JButton e1 = new JButton("E");
		e1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		e1.setBounds(431, 91, 100, 74);
		contentPane.add(e1);
		
		f = new JButton("F");
		f.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		f.setBounds(530, 91, 113, 74);
		contentPane.add(f);
		
		g = new JButton("G");
		g.setBounds(10, 165, 100, 74);
		contentPane.add(g);
		
		h = new JButton("H");
		h.setBounds(107, 164, 106, 75);
		contentPane.add(h);
		
		i = new JButton("I");
		i.setBounds(209, 165, 113, 74);
		contentPane.add(i);
		
		JButton j = new JButton("J");
		j.setBounds(318, 165, 113, 74);
		contentPane.add(j);
		
		JButton k = new JButton("K");
		k.setBounds(431, 165, 100, 74);
		contentPane.add(k);
		
		JButton l = new JButton("L");
		l.setBounds(530, 165, 113, 74);
		contentPane.add(l);
		
		JButton m = new JButton("M");
		m.setBounds(10, 226, 100, 89);
		contentPane.add(m);
		
		JButton n = new JButton("N");
		n.setBounds(107, 226, 106, 89);
		contentPane.add(n);
		
		JButton o = new JButton("O");
		o.setBounds(209, 226, 113, 89);
		contentPane.add(o);
		
		JButton p = new JButton("P");
		p.setBounds(318, 226, 113, 89);
		contentPane.add(p);
		
		JButton q = new JButton("Q");
		q.setBounds(431, 226, 100, 89);
		contentPane.add(q);
		
		JButton r = new JButton("R");
		r.setBounds(530, 226, 113, 89);
		contentPane.add(r);
		
		JButton s = new JButton("S");
		s.setBounds(10, 315, 100, 74);
		contentPane.add(s);
		
		JButton t = new JButton("T");
		t.setBounds(107, 315, 106, 74);
		contentPane.add(t);
		
		JButton u = new JButton("U");
		u.setBounds(209, 315, 113, 74);
		contentPane.add(u);
		
		JButton v = new JButton("V");
		v.setBounds(318, 315, 113, 74);
		contentPane.add(v);
		
		JButton w = new JButton("W");
		w.setBounds(431, 314, 100, 75);
		contentPane.add(w);
		
		JButton x = new JButton("X");
		x.setBounds(530, 313, 113, 76);
		contentPane.add(x);
		
		JButton y = new JButton("Y");
		y.setBounds(10, 389, 100, 74);
		contentPane.add(y);
		
		JButton z = new JButton("Z");
		z.setBounds(107, 389, 106, 74);
		contentPane.add(z);
		
		JButton sp = new JButton("SPACE");
		sp.setBounds(209, 388, 322, 75);
		contentPane.add(sp);
		
		JButton bsp = new JButton("BACK SPACE");
		bsp.setBounds(530, 389, 113, 74);
		contentPane.add(bsp);
		
		JButton back = new JButton("BACK");
		back.setBounds(641, 91, 106, 74);
		contentPane.add(back);
		
		JButton ok = new JButton("OK");
		ok.setBounds(641, 165, 106, 74);
		contentPane.add(ok);
		
		JButton back1 = new JButton("BACK");
		back1.setBounds(641, 239, 106, 76);
		contentPane.add(back1);
		
		JButton btnNewButton_25 = new JButton("OK");
		btnNewButton_25.setBounds(641, 315, 106, 74);
		contentPane.add(btnNewButton_25);
		
		JButton back3 = new JButton("BACK");
		back3.setBounds(641, 385, 106, 78);
		contentPane.add(back3);
	}
}
