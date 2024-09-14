 package f_stage
 import chisel3._
 import chisel3.tester._
 import org.scalatest.FreeSpec
 import chisel3.experimental.BundleLiterals._

 class decode_tst extends FreeSpec with ChiselScalatestTester{
     "Chisel" in{
         test(new decode){a =>
             a.io.ins.poke("b00000000011000000000000010010011".U)
             a.clock.step(5)
             a.io.imm_out.expect(6.S)
             a.io.ins_out.expect("b00000000011000000000000010010011".U)
             a.io.rs1_data.expect(0.S)
             a.io.rs2_data.expect(0.S)

        
         }
     }
 }