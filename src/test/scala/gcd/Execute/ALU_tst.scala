package f_stage
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class ALU_tst extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new ALU) { a =>
      a.io.ins.poke("b00000010000000000110000000110011".U) 
      a.io.imm.poke(8.S) 
      a.io.arg_x.poke(15.S) 
      a.io.arg_y.poke(7.S) 
      a.clock.step(1) 
      a.io.alu_out.expect(1.S)
      a.io.imm_out.expect(8.S)
    }
  }
}