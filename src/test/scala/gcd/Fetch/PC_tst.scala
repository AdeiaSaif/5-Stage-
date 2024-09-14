// package f_stage
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec

// class PC_tst extends FreeSpec with ChiselScalatestTester {
//   "Chisel" in {
//     test(new PC) { a =>
//       a.io.pre_pc.poke(4.S) 
//       a.io.imm.poke(16.S) 
//       a.clock.step(1) 
//       a.io.pc_out.expect(20.S)
//     }
//   }
// }