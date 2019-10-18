package main


import "fmt"

func main()  {
	testIota()
}
func testIota()  {
	const (
		a = iota
		b
		c
		d = iota
		i = 10

	)
	fmt.Println(a,b,c,d,i)
}