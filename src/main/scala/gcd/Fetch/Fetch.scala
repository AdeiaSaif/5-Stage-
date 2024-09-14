package f_stage
import chisel3._

object For_PC {
  val LOAD = "b0000011".U(7.W)
  val BRANCH = "b1100011".U(7.W)
  val JAL = "b1101111".U(7.W)
  val JALR = "b1100111".U(7.W)
}


import For_PC._
class Fetch extends Module{
    val io=IO(new Bundle{
        val imm=Input(SInt(32.W))
        val inst=Input(UInt(32.W))
        
        val inst_out=Output(UInt(32.W))
        val pc_out=Output(UInt(32.W))
    })

    val pc = Module(new PC(0))
    dontTouch(pc.io)
    val pc4 = Module(new PC4(0))
    dontTouch(pc4.io)

    pc.io.imm:=io.imm
    io.inst_out:=io.inst
    io.pc_out:=Mux((io.inst(6,0)===LOAD || io.inst(6,0)===BRANCH || io.inst(6,0)===JAL || io.inst(6,0)===JALR), pc.io.pc_out,pc4.io.pc4_out)
}
