package com.project.board;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.project.board.dao.MemeberDAO;


public class LoginFrame extends JFrame {
	
	private JPanel contentPane;
	private JTextField user_id, user_pw;
	private JButton loginBtn, joinBtn;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel login = new JLabel("아이디");
		login.setBounds(41, 52, 69, 35);
		contentPane.add(login);
		
		user_id = new JTextField();
		user_id.setBounds(157, 52, 176, 35);
		contentPane.add(user_id);
		user_id.setColumns(10);
		
		JLabel pw = new JLabel("비밀번호");
		pw.setBounds(41, 103, 69, 35);
		contentPane.add(pw);
		
		user_pw = new JTextField();
		user_pw.setBounds(157, 103, 176, 35);
		contentPane.add(user_pw);
		user_pw.setColumns(10);
		
		joinBtn = new JButton("회원가입");
		joinBtn.setBounds(229, 154, 104, 29);
		contentPane.add(joinBtn);
		
		loginBtn = new JButton("로그인");
		loginBtn.setBounds(108, 154, 106, 29);
		contentPane.add(loginBtn);
		
		setVisible(true);
		
		joinBtn.addActionListener(new ActionListener() {
			
			// 회원가입
			@Override
			public void actionPerformed(ActionEvent e) {
				JoinFrame frame = new JoinFrame();
			}
		});
		
		// 로그인
		loginBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String 아이디 = user_id.getText(); 
				String 비밀번호 = user_pw.getText();
				MemeberDAO memeberDAO = MemeberDAO.getInstance();
				int result = memeberDAO.selectUserByUsernameAndPassword(아이디, 비밀번호);
				if(result == 1) {
					JOptionPane.showMessageDialog(null, "로그인 성공");
					dispose();
				}else {
					JOptionPane.showMessageDialog(null, "로그인 실패");
				}
			}
		});
		
		
	}

}
