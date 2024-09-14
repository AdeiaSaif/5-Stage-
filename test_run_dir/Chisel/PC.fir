;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit PC : 
  module PC : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip pre_pc : SInt<32>, flip imm : SInt<32>, pc_out : SInt<32>}
    
    reg pc : SInt<32>, clock with : (reset => (reset, asSInt(UInt<32>("h00")))) @[PC.scala 9:19]
    node _pc_T = add(io.pre_pc, io.imm) @[PC.scala 10:18]
    node _pc_T_1 = tail(_pc_T, 1) @[PC.scala 10:18]
    node _pc_T_2 = asSInt(_pc_T_1) @[PC.scala 10:18]
    pc <= _pc_T_2 @[PC.scala 10:7]
    io.pc_out <= pc @[PC.scala 11:14]
    
