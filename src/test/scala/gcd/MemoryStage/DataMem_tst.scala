package f_stage
import chisel3._
import chisel3.tester._
import org.scalatest.FreeSpec

class DataMem_tst extends FreeSpec with ChiselScalatestTester {
  "Chisel" in {
    test(new DataMemory) { a =>
      a.io.address.poke(1.U) 
      a.io.din.poke(15.S) 
      a.io.imm.poke(15.S) 
      a.io.inst.poke(15.U) 
      a.io.store.poke(1.B) 
      a.io.load.poke(0.B) 
      a.clock.step(1) 

      a.io.address.poke(1.U) 
      a.io.din.poke(15.S) 
      a.io.imm.poke(15.S) 
      a.io.inst.poke(15.U) 
      a.io.store.poke(0.B) 
      a.io.load.poke(1.B) 
      a.clock.step(1) 

   
      a.io.dout.expect(15.S) 
      a.io.imm_out.expect(15.S) 
      a.io.inst.expect(15.U) 
    }
  }
}