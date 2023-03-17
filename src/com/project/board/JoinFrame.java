package com.project.board;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.project.board.dao.MemeberDAO;
import com.project.board.dto.MemberDTO;

public class JoinFrame extends JFrame {
	
	private JPanel contentPane;
	private JLabel join;
	private JButton joinCompleteBtn;
	private JTextField user_id, user_pw, user_name, user_email;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					JoinFrame frame = new JoinFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public JoinFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(430, 490);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		join = new JLabel("회원가입");
		Font font = new Font("돋움", Font.BOLD, 20);
		join.setFont(font);
		join.setBounds(165, 41, 101, 20);
		contentPane.add(join);
		
		JLabel username = new JLabel("이름");
		username.setBounds(69, 113, 69, 20);
		contentPane.add(username);
		
		JLabel id = new JLabel("아이디");
		id.setBounds(69, 163, 69, 20);
		contentPane.add(id);
		
		JLabel pw = new JLabel("비밀번호");
		pw.setBounds(69, 210, 69, 20);
		contentPane.add(pw);
		
		JLabel email = new JLabel("e-mail");
		email.setBounds(69, 257, 69, 20);
		contentPane.add(email);
		
		user_name = new JTextField();
		user_name.setColumns(10);
		user_name.setBounds(159, 106, 186, 35);
		contentPane.add(user_name);
		
		user_id = new JTextField();
		user_id.setColumns(10);
		user_id.setBounds(159, 156, 186, 35);
		contentPane.add(user_id);
		
		user_pw = new JTextField();
		user_pw.setColumns(10);
		user_pw.setBounds(159, 203, 186, 35);
		contentPane.add(user_pw);
		
		user_email = new JTextField();
		user_email.setColumns(10);
		user_email.setBounds(159, 250, 186, 35);
		contentPane.add(user_email);
		
		joinCompleteBtn = new JButton("회원가입 성공");
		joinCompleteBtn.setBounds(150, 320, 139, 29);
		contentPane.add(joinCompleteBtn);
		
		setVisible(true);
		joinCompleteBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				MemberDTO memberDTO = new MemberDTO();
				memberDTO.setUser_id(user_id.getText());
				memberDTO.setUser_pw(user_pw.getText());
				memberDTO.setUser_name(user_name.getText());
				memberDTO.setEmail(user_email.getText());
				
				MemeberDAO memeberDAO = MemeberDAO.getInstance();
				int result = memeberDAO.insertMember(memberDTO);
				
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "회원가입이 성공적으로 되셨습니다");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "회원가입에 실패하셨습니다");
					dispose();
				}
			}
		});
		
	}

}
