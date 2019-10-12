package io.mine.ft.train.bibao;

import java.io.FileReader;
import java.net.URL;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class Jdk8Nashorn {
	//在Java8之前，如果要调用js语言是用Rhino调用，Java8只会自动升级到Nashorn，下面有一个例子
	public static void main(String[] args) throws Exception {
		//获取脚本引擎的对象
		ScriptEngineManager sem = new ScriptEngineManager();
		ScriptEngine engine = sem.getEngineByName("javascript");
		System.out.println(engine.getClass().getName());
		//定义变量,存储到引擎的上下文中
		engine.put("msg", "hello world!");
		String str = "var user = {name:'zs',age:18,schools:['北京大学','清华大学']};";
		//执行脚本
		engine.eval(str);
		engine.eval("msg = 'hi !';");
		System.out.println(engine.get("msg"));//获取变量
		engine.eval("var sum = eval('1+222+33*4');");//调用js的eval的方法完成运算
		System.out.println(engine.get("sum"));//获取变量

		//定义函数
		engine.eval("function add(a,b){ return a+b;}");
		//执行js函数
		Invocable jsInvoke = (Invocable)engine;
		Object obj = jsInvoke.invokeFunction("add", 1,2);//方法的名字，参数
		System.out.println(obj);

		//执行一个js的文件
		URL resource = Jdk8Nashorn.class.getClassLoader().getResource("a.js");//当前项目的bin目录的a.js
		FileReader fr = new FileReader(resource.getPath());
		engine.eval(fr);

		//执行js函数
		Invocable jsInvoke2 = (Invocable)engine;
		Object obj2 = jsInvoke2.invokeFunction("a", 1,2);//方法的名字，参数
		System.out.println(obj2);
	
	}
}
