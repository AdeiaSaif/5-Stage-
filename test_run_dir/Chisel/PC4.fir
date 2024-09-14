;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit PC4 : 
  module PC4 : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip pre_pc : UInt<32>, pc_out : UInt<32>}
    
    reg pc : UInt<32>, clock with : (reset => (reset, UInt<32>("h00"))) @[PC4.scala 8:19]
    node _pc_T = add(io.pre_pc, UInt<3>("h04")) @[PC4.scala 9:18]
    node _pc_T_1 = tail(_pc_T, 1) @[PC4.scala 9:18]
    pc <= _pc_T_1 @[PC4.scala 9:7]
    io.pc_out <= pc @[PC4.scala 10:14]
    
