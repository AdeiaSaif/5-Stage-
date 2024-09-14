package f_stage
import chisel3._
import chisel3.util._
object R_I {
  val ALU_ADD = 0.U(4.W)
  val ALU_SLL = 1.U(4.W)
  val ALU_SLT = 2.U(4.W)
  val ALU_SLTU = 3.U(4.W)
  val ALU_XOR = 4.U(4.W)
  val ALU_SRL = 5.U(4.W)
  val ALU_OR = 6.U(4.W)
  val ALU_AND = 7.U(4.W)
  val ALU_SUB = 8.U(4.W)
  val ALU_SRA = 13.U(4.W)
}
object Branch {
  val ALU_Beq = 0.U(4.W)
  val ALU_Bne = 1.U(4.W)
  val ALU_Blt = 4.U(4.W)
  val ALU_Bge = 5.U(4.W)
  val ALU_Bltu = 6.U(4.W)
  val ALU_Bgeu = 7.U(4.W)
}
object M_ex {
  val ALU_mult = 0.U(4.W)
  val ALU_div = 4.U(4.W)
  val ALU_rem = 6.U(4.W)
}
import Branch._
import R_I._
import M_ex._
class ALU extends Module{
    val io=IO(new Bundle{
        val ins=Input(UInt(32.W))
        val arg_x=Input(SInt(32.W))
        val arg_y=Input(SInt(32.W))
        val imm=Input(SInt(32.W))

        val imm_out=Output(SInt(32.W))
        val ins_out=Output(UInt(32.W))
        val alu_out=Output(SInt(32.W))
    })
    io.imm_out:=io.imm
    io.alu_out:=0.S
    io.ins_out:=io.ins
    val opcode=io.ins(6,0)
    val fun3=io.ins(14,12)
    val fun7=io.ins(31,25)
    when((opcode=== "b0110011".U) &&  fun7 =/= 1.U || (opcode=== "b0010011".U) ) {
    when(fun3 === ALU_ADD) {
      io.alu_out := io.arg_x + io.arg_y
    }
      .elsewhen(fun3 === ALU_SUB) {
        io.alu_out := io.arg_x - io.arg_y
      }
      .elsewhen(fun3 === ALU_AND) {
        io.alu_out := io.arg_x & io.arg_y
      }
      .elsewhen(fun3 === ALU_OR) {
        io.alu_out := io.arg_x | io.arg_y
      }
      .elsewhen(fun3 === ALU_XOR) {
        io.alu_out := io.arg_x ^ io.arg_y
      }
      .elsewhen(fun3 === ALU_SLT) {
        io.alu_out := (io.arg_x < io.arg_y).asSInt
      }
      .elsewhen(fun3 === ALU_SLL) {
        io.alu_out := (io.arg_x << io.arg_y(4, 0))
      }
      .elsewhen(fun3 === ALU_SLTU) {
        io.alu_out := (io.arg_x < io.arg_y).asSInt
      }
      .elsewhen(fun3 === ALU_SRL) {
        io.alu_out := (io.arg_x >> io.arg_y(4, 0))
      }
      .elsewhen(fun3 === ALU_SRA) {
        io.alu_out := (io.arg_x >> io.arg_y(4, 0))
      }
      .otherwise {
        io.alu_out := 0.S
      }
  }

    // load address calculation
    .elsewhen(opcode=== "b0000011".U) {
      io.alu_out := io.arg_y + io.arg_x
    }
   
    // Branch
    .elsewhen(opcode=== "b1100011".U) { // Branch instructions
      when(fun3 === ALU_Beq) {
        io.alu_out := Mux(io.arg_x === io.arg_y, 1.S, 0.S)
         }
         .elsewhen(fun3 === ALU_Bne) {
        io.alu_out := Mux(io.arg_x =/= io.arg_y, 1.S, 0.S)
      }
      .elsewhen(fun3 === ALU_Blt) {
        io.alu_out := Mux(io.arg_x < io.arg_y, 1.S, 0.S)
      }.elsewhen(fun3 === ALU_Bge) {
        io.alu_out := Mux(io.arg_x >= io.arg_y, 1.S, 0.S)
      }.elsewhen(fun3 === ALU_Bltu) {
        io.alu_out := Mux(io.arg_x.asUInt < io.arg_y.asUInt, 1.S, 0.S)
      }.elsewhen(fun3 === ALU_Bgeu) {
        io.alu_out := Mux(io.arg_x.asUInt >= io.arg_y.asUInt, 1.S, 0.S)
      }
      .otherwise{
      io.alu_out := 0.S

      }
    }
    //jalr 
.elsewhen(opcode=== "b1100111".U) {
      io.alu_out := io.arg_x + io.arg_y
    }
    .elsewhen(opcode=== "b0110011".U && fun7 === 1.U) {
       when(fun3 === ALU_mult ) {
      io.alu_out := io.arg_x * io.arg_y
    }
      .elsewhen(fun3 === ALU_div) {
        io.alu_out := io.arg_x / io.arg_y
      }
      .elsewhen(fun3 === ALU_rem) {
        io.alu_out := io.arg_x % io.arg_y
      }
       .otherwise{
      io.alu_out := 0.S

      }
    }
}