package f_stage
import chisel3._
import chisel3.util._

class RegFile extends Module {
  var io = IO(new Bundle {
    val rs1 = Input(UInt(5.W))
    val rs2 = Input(UInt(5.W))
    val rd = Input(UInt(5.W))
    val data = Input(SInt(32.W))
    val w_en=Input(Bool())

    
    val out1 = Output(SInt(32.W))
    val out2 = Output(SInt(32.W))

  })

  val Regfile = RegInit(VecInit(Seq.fill(32)(0.S(32.W))))
  when(io.rs1.orR) {
    io.out1 := Regfile(io.rs1)
  }
  .otherwise{
    io.out1 :=0.S
  }
  when(io.rs2.orR) {
    io.out2 := Regfile(io.rs2)
  }
  .otherwise{
    io.out2 :=0.S
  }
  when(io.rd.orR && io.w_en===1.B) {
    Regfile(io.rd) := io.data
  }

}