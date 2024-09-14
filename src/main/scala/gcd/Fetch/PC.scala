package f_stage
import chisel3._
class PC(val min:Int =0) extends Module{
    val io=IO(new Bundle{
        val imm=Input(SInt(32.W))

        val pc_out=Output(UInt(32.W))
    })
    val pc=RegInit(min.U(32.W))
    pc:=pc+(io.imm).asUInt
    io.pc_out:=pc
}
