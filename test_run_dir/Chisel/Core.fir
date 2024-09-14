;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Core : 
  module PC4 : 
    input clock : Clock
    input reset : Reset
    output io : {flip pre_pc : SInt<32>, pc_out : SInt<32>}
    
    reg pc : SInt<32>, clock with : (reset => (reset, asSInt(UInt<32>("h00")))) @[PC4.scala 8:19]
    node _pc_T = add(io.pre_pc, asSInt(UInt<4>("h04"))) @[PC4.scala 9:18]
    node _pc_T_1 = tail(_pc_T, 1) @[PC4.scala 9:18]
    node _pc_T_2 = asSInt(_pc_T_1) @[PC4.scala 9:18]
    pc <= _pc_T_2 @[PC4.scala 9:7]
    io.pc_out <= pc @[PC4.scala 10:14]
    
  module Core : 
    input clock : Clock
    input reset : UInt<1>
    output io : {}
    
    inst pc4 of PC4 @[Core.scala 9:21]
    pc4.clock <= clock
    pc4.reset <= reset
    pc4.io.pre_pc <= asSInt(UInt<1>("h00")) @[Core.scala 11:18]
    
