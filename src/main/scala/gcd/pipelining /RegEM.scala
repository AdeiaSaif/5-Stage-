package f_stage
import chisel3._
import chisel3.util._

class RegEM extends Module {
  val io = IO(new Bundle {
    val inst=Input(UInt(32.W))
    val address = Input(UInt(32.W))
    val din = Input(SInt(32.W))
    val imm = Input(SInt(32.W))
    val load = Input(Bool())
    val store = Input(Bool())

    val inst_out=Output(UInt(32.W))
    val address_out = Output(UInt(32.W))
    val dout = Output(SInt(32.W))
    val imm_out = Output(SInt(32.W))
    val load_out = Output(Bool())
    val store_out = Output(Bool())
  })

  val inst =RegInit(0.U(32.W))
  val add =RegInit(0.U(32.W))
  val din =RegInit(0.S(32.W))
  val imm =RegInit(0.S(32.W))
  val load_en =RegInit(0.B)
  val store_en =RegInit(0.B)

  inst:=io.inst
  add:=io.address
  din:=io.din
  imm:=io.imm
  load_en:=io.load
  store_en:=io.store

  io.inst_out:=inst
  io.address_out:=add
  io.dout:=din
  io.imm_out:=imm
  io.load_out:=load_en
  io.store_out:=store_en

}