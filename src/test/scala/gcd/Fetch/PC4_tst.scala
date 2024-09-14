// package f_stage
// import chisel3._
// import chisel3.tester._
// import org.scalatest.FreeSpec

// class PC4_tst extends FreeSpec with ChiselScalatestTester {
//   "Chisel" in {
//     test(new PC4) { a =>
//       a.io.pre_pc.poke(0.S) 
//       a.clock.step(1) 
//       a.io.pc_out.expect(4.S)
//     }
//   }
// }