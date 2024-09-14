package f_stage
import chisel3._
class PC4(val min:Int =0) extends Module{
    val io=IO(new Bundle{
        val pc4_out=Output(UInt(32.W))
    })
    val pc=RegInit(min.U(32.W))
    pc:=pc+4.U
    io.pc4_out:=pc
}
