package f_stage
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class fetch_tst extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new Fetch) { a =>
      a.io.imm.poke(16.S) 
      a.io.inst.poke("b00000000001000001001001001100011".U) 
      a.clock.step(1) 
      a.io.inst_out.expect("b00000000001000001001001001100011".U)
      a.io.pc_out.expect(16.U)
    }
  }
}