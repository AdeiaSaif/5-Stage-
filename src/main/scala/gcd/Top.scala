package f_stage
import chisel3._
import chisel3.util._
import chisel3.util.experimental.loadMemoryFromFile
import scala.io.Source

class Top extends Module {
  val io = IO(new Bundle {
    val address = Input(UInt(32.W))
    val inst = Output(UInt(32.W))
    })


    val inst_mem = Module(new InstMem("#"))
    dontTouch(inst_mem.io)
    val core = Module(new Core)
    dontTouch(core.io)
    inst_mem.io.address:=core.io.address
    core.io.inst:=inst_mem.io.inst

  
}