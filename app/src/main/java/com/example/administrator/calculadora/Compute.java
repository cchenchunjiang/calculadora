package com.example.administrator.calculadora;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
public class Compute {
	private List<String> code;
	private Stack<String> sta;
	public Compute(){
		code=new ArrayList<>();
		sta = new Stack<>();
	}
	//进出栈优先级
	public int  icp(String c){
		switch (c) {
			case "+":return 2;
			case "-":return 2;
			case "*":return 4;
			case "/":return 4;
			case "sin":return 6;
			case "cos":return 6;
			case "tan":return 6;
			case "cot":return 6;
			case "log":return 6;
			case "√":return 6;
			case "[^2":return 6;
			case "^":return 6;
			case "(":return 9;
			case ")":return 1;
			case "#":return 0;
			case "1":return 10;
			case "2":return 10;
			case "3":return 10;
			case "4":return 10;
			case "5":return 10;
			case "6":return 10;
			case "7":return 10;
			case "8":return 10;
			case "9":return 10;
			case "0":return 10;
			case ".":return 10;
			case "π":return 10;
			default:
				return -1;

		}
	}
	//进出栈优先级
	public int isp(String c){
		switch (c) {
			case "+":return 3;
			case "-":return 3;
			case "*":return 5;
			case "/":return 5;
			case "sin":return 7;
			case "cos":return 7;
			case "tan":return 7;
			case "cot":return 7;
			case "log":return 7;
			case "√":return 7;
			case "[^2":return 7;
			case "^":return 7;
			case "(":return 1;
			case ")":return 9;
			case "#":return 0;
			default:
				return -1;
		}
	}
	//算式编码
	public void coding(String s){
		s="#"+s+"#";
		char[] c=s.toCharArray();
		Boolean sign=false;//表示数字记录完毕
		String temp="";
		for(int i=0;i<c.length;i++){
			if(icp(c[i]+"") == -1){
				//复杂运算的长度为3，取3位字符入栈
				temp=""+c[i++]+""+c[i++]+""+c[i]+"";
				queue(temp,i-2);
				temp="";
			}
			//排除一定不是作为运算符的 “-”
			else if (icp(c[i]+"") == 10 || (c[i] == '-' && icp(c[i - 1]+"") != 10 && icp(c[i - 1]+"") != 1&& icp(c[i+1]+"") !=9)) {
				temp+=c[i];
				sign=true;
			}
			//排除一定不是作为负号的“-”
			else if ((icp(c[i]+"")!=10&&icp(c[i]+"")>=0&&c[i]!='-')||(c[i] == '-' && (icp(c[i-1]+"") == 10 || icp(c[i-1]+"") == 1 || icp(c[i+1]+"") == 9))){
				if(sign==true){
					code.add(temp);
					temp="";
					sign=false;
				}
				queue(c[i]+"",i);
			}
		}
	}
	//排列运算符的计算顺序
	public void queue(String c,int i){
		while (true) {
			if(i==0){
				sta.push(c);
				break;
			}
			if(sta.isEmpty())
				break;
			if (isp(sta.peek()) < icp(c)) {
				sta.push(c);
				break;
			}
			if (isp(sta.peek()) == icp(c)) {
				sta.pop();
				break;
			}
			if (isp(sta.peek()) > icp(c)) {
				code.add(sta.pop()+"");
			}
		}
	}
	//算式解码
	public String encodeing(String s){
		coding(s);
		Stack<BigDecimal> sta=new Stack<>();
		String last="";
		boolean bool=true;
		BigDecimal bb;
		for(int i=0;i<code.size();i++){
			last=code.get(i);
			//当前为如下运算符
			if(last.equals("sin")||last.equals("cos")||last.equals("tan")||last.equals("log")||last.equals("√")||last.equals("[^2")){
				if(sta.size()>=1){
					bb=compute2(sta.pop(),last);
					if(bb==null){
						bool=false;
						break;
					}
					sta.push(bb);
				}
				else{
					bool=false;
					break;
				}
			}
			//当前为如下运算符
			else if(last.equals("^")||last.equals("+")||last.equals("-")||last.equals("/")||last.equals("*")){
				if(sta.size()>=2){
					bb=compute1(sta.pop(),sta.pop(),last);
					if(bb==null){
						bool=false;
						break;
					}
					sta.push(bb);
				}
				else{
					bool=false;
					break;
				}
			}//当前为数字
			else{
				try{
					if(last.equals("π"))
						sta.push(new BigDecimal(Math.PI));
					else
						sta.push(new BigDecimal(last));
				}catch(Exception e){
					bool=false;
					break;
				}
			}
		}
		if(bool==false)
			return null;
		return sta.pop().toString();
	}

	//计算
	public BigDecimal compute1(BigDecimal b1,BigDecimal b2,String op){
		System.out.println(b1.toString()+"   "+b2.toString());
		switch (op){
			case  "^":
				return new BigDecimal(Math.pow(b2.doubleValue(), b1.doubleValue()));
			case  "+":
				return b2.add(b1);
			case   "-":
				return b2.subtract(b1);
			case   "*":
				return b2.multiply(b1);
			case   "/":
				if(b1.doubleValue()==0){
					return null;
				}
				return b2.divide(b1, 10, BigDecimal.ROUND_HALF_UP);
			default:
				return null;
		}
	}
	public BigDecimal compute2(BigDecimal b1,String op){

		switch (op){
			case "sin":return new BigDecimal(Math.sin(b1.doubleValue()));
			case "cos":return new BigDecimal(Math.cos(b1.doubleValue()));
			case "tan":return new BigDecimal(Math.tan(b1.doubleValue()));
			case "log":return new BigDecimal(Math.log(b1.doubleValue()));
			case  "√": return new BigDecimal(Math.sqrt(b1.doubleValue()));
			case "[^2":
				System.out.println("asdasd");
				return b1.multiply(b1);
			default:
				return null;
		}
	}
}
