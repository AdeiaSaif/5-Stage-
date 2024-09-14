package f_stage
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source

class InstMem(initFile: String) extends Module {
  val io = IO(new Bundle {
    val address = Input(UInt(32.W))
    val inst = Output(UInt(32.W))
  })
    val memory = Mem(1024, UInt(32.W))
    loadMemoryFromFile(memory, initFile)
    io.inst:=memory(io.address >>2.U )
  
}