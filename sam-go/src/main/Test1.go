package main

import (
	"fmt"
)

const const1 string = "常量"
const (
	const2 = 10
	const3 = false
)
func main()  {
	callTest()
}
func callTest()  {
	//单行注释
	/*
	多行注释
	 */
	fmt.Println("hello,test1!")
	fmt.Println("hello,go!")
	fmt.Println("hello"+","+"google !")
	var apple , orange int = 1,2
	var age  = apple + orange
	var a int
	fmt.Println(age)
	fmt.Println(a)
	fmt.Printf("%v %v %v %q\n",0,0.01,false,"test")
	str := "Runoob"
	fmt.Println(str)
	_,numb,strs := returnValue()
	fmt.Println(numb,strs)

	fmt.Println(const1)
	fmt.Println(const2 )
	fmt.Println(const3)
}

func returnValue()(int,int, string){
	a , b , c := 1 , 2, "str"
   return a,b,c
}