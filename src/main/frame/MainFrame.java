package main.frame;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;


public class MainFrame extends JFrame{

	public JPanel mainPanel = null;
	public JPanel controlPanel = null;
	
	public JMenuBar menu = null;	
	public Timer timer = new Timer();
	
	public int x = 0;
	public int y = 0;
	public int w = 0;
	public int h = 0;
	
	public Rectangle main = null;
	public Rectangle control = null;
	public float FRAME_OF_FULL_RATIO = 0.8f;
	public float MAIN_OF_FRAME = 0.8f;
	
	
	public static void main(String[] args){
		MainFrame mf = new MainFrame();
		mf.setVisible(true);
		
	}
	
	public MainFrame(){
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension fullScreen = toolkit.getScreenSize();
		this.w = (int)(fullScreen.getWidth()*FRAME_OF_FULL_RATIO);
		this.h = (int)(fullScreen.getHeight()*FRAME_OF_FULL_RATIO);
		this.x = (int)((fullScreen.getWidth()*(1.0f-FRAME_OF_FULL_RATIO))*0.5);
		this.y = (int)((fullScreen.getHeight()*(1.0f-FRAME_OF_FULL_RATIO))*0.5);
		main = new Rectangle(0, 0, (int)(this.w*0.8f), this.h);
		control = new Rectangle((int)(this.w*0.8f), 0, (int)(this.w*(1.0f-0.8f)), this.h);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setBounds(this.x, this.y, this.w, this.h);
//		this.setResizable(false);
		this.setTitle("Stocker");
		
		initMenuBar();
		initControlPanel();
	}
	
	public void initMenuBar(){
		if(menu==null){
			menu = new JMenuBar();
		}
		
		
		this.setJMenuBar(menu);
	};
	
	public void initControlPanel(){
		controlPanel = new ControlPanel();
		this.add(controlPanel);
	}
	
	public boolean initialMainPanel(){
		if(mainPanel==null){
			mainPanel = new MainPanel(timer);
			mainPanel.setBounds(main);
			this.add(mainPanel);
			return true;
		}else{
			return false;
		}
	};
	
	public boolean destroyMainPanel(){
		if(mainPanel!=null){
			this.remove(mainPanel);
			if(mainPanel!=null){
				mainPanel = null;
			}
			return true;
		}else{
			return false;
		}
	}
	
	public class MainPanel extends JPanel{

		public static final long FREQUENT_PERIOD = 5000;
		public static final long LAZY_PERIOD = 6000;
		
		private long period = LAZY_PERIOD;
		private boolean doDraw = true;
		private long now = System.currentTimeMillis();
		
		Calendar c = Calendar.getInstance(TimeZone.getTimeZone("GMT+8"));
		
		public MainPanel(Timer timer){
			
			timer.schedule(new TimerTask() {
				
				@Override
				public void run() {
					c.setTimeInMillis(System.currentTimeMillis());
					
					setPeroid(c);
					if(doDraw){
						MainPanel.this.repaint();
					}else{
						
					}
				}
			}, 0, period);
		}
		
		public int setPeroid(Calendar c){
//			pl(System.currentTimeMillis() - this.now);
			int hour = c.get(Calendar.HOUR_OF_DAY);
			int minute = c.get(Calendar.MINUTE);
			switch(hour){
				case 9:
					//09点25分之后,刷新频率为5秒
					period = minute>25?FREQUENT_PERIOD:LAZY_PERIOD;
					break;
				case 10:
					//10点之后,刷新频率为5秒
					period = FREQUENT_PERIOD;
					break;
				case 11:
					//11点35分之前,刷新频率为5秒
					period = minute<35?FREQUENT_PERIOD:LAZY_PERIOD;
					break;
				case 12:
					//12点55分之后,刷新频率为5秒
					period = minute>55?FREQUENT_PERIOD:LAZY_PERIOD;
					break;
				case 13:
				case 14:
					//13点整-15点整,刷新频率为5秒
					period = FREQUENT_PERIOD;
					break;
				case 15:
					//15点5分之前,刷新频率为5秒
					period = minute<5?FREQUENT_PERIOD:LAZY_PERIOD;
					break;
				default:
					//其余时间,刷新频率为60秒
					period = LAZY_PERIOD;
			}
			return minute;
		}
		
	    public void repaint() {
//	    	pl("1");
	        super.repaint();
	    }
		
	}
	
	public class ControlPanel extends JPanel{
		
		public JButton showPanel = null;
		public boolean hasPanel = false;
		
		public ControlPanel(){
			this.setLayout(null);
			this.setBounds(control);
			this.setBorder(new BevelBorder(BevelBorder.LOWERED));
//			pl(control);
			initButtons();
		}
		
		public void initButtons(){
			showPanel = new JButton();
			showPanel.setBounds(10,10,80,26);
			showPanel.setText(hasPanel?"结束":"开始");
			showPanel.setFocusable(false);
			showPanel.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					if(hasPanel){
						if(destroyMainPanel()){
							showPanel.setText("开始");
							hasPanel = false;
						}
					}else{
						if(initialMainPanel()){
							showPanel.setText("结束");
							hasPanel = true;
						}	
					}
				}
			});
			this.add(showPanel);
		}
	}
	
	public static void pl(Object o){
		System.out.println(o);
	}
	public static void p(Object o){
		System.out.print(o);
	}
	public static void pl(){
		System.out.println();
	}
}
