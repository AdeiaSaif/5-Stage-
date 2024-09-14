package f_stage
import chisel3._
import chisel3.util._

class DataMemory extends Module {
  val io = IO(new Bundle {
    val inst=Input(UInt(32.W))
    val address = Input(UInt(32.W))
    val din = Input(SInt(32.W))
    val load = Input(Bool())
    val store = Input(Bool())
    val imm =Input(SInt(32.W))

    val imm_out=Output(SInt(32.W))
    val dout = Output(SInt(32.W))
    val inst_out=Output(UInt(32.W))
  })
  io.imm_out:=io.imm
  io.inst_out:=io.inst
  val memory = Mem(1024, SInt(32.W))
  when(io.store === 1.B) {
    memory.write(io.address, io.din)
  }
  io.dout := Mux(io.load === 1.B, memory(io.address), 0.S)

}