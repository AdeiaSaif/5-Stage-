package f_stage
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class WriteBack_tst extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new WriteBack) { a =>
      a.io.alu_data.poke(20.S) 
      a.io.mem_data.poke(15.S) 
      a.io.load_en.poke(1.B) 
      a.clock.step(1) 
      a.io.out.expect(15.S) 
    }
  }
}