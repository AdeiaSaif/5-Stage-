;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit Fetch : 
  module PC : 
    input clock : Clock
    input reset : Reset
    output io : {flip imm : SInt<32>, pc_out : UInt<32>}
    
    reg pc : UInt<32>, clock with : (reset => (reset, UInt<32>("h00"))) @[PC.scala 9:19]
    node _pc_T = asUInt(io.imm) @[PC.scala 10:21]
    node _pc_T_1 = add(pc, _pc_T) @[PC.scala 10:11]
    node _pc_T_2 = tail(_pc_T_1, 1) @[PC.scala 10:11]
    pc <= _pc_T_2 @[PC.scala 10:7]
    io.pc_out <= pc @[PC.scala 11:14]
    
  module PC4 : 
    input clock : Clock
    input reset : Reset
    output io : {pc4_out : UInt<32>}
    
    reg pc : UInt<32>, clock with : (reset => (reset, UInt<32>("h00"))) @[PC4.scala 7:19]
    node _pc_T = add(pc, UInt<3>("h04")) @[PC4.scala 8:11]
    node _pc_T_1 = tail(_pc_T, 1) @[PC4.scala 8:11]
    pc <= _pc_T_1 @[PC4.scala 8:7]
    io.pc4_out <= pc @[PC4.scala 9:15]
    
  module Fetch : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip imm : SInt<32>, flip inst : UInt<32>, inst_out : UInt<32>, pc_out : UInt<32>}
    
    inst pc of PC @[Fetch.scala 22:20]
    pc.clock <= clock
    pc.reset <= reset
    inst pc4 of PC4 @[Fetch.scala 24:21]
    pc4.clock <= clock
    pc4.reset <= reset
    pc.io.imm <= io.imm @[Fetch.scala 27:14]
    io.inst_out <= io.inst @[Fetch.scala 28:16]
    node _io_pc_out_T = bits(io.inst, 6, 0) @[Fetch.scala 29:28]
    node _io_pc_out_T_1 = eq(_io_pc_out_T, UInt<7>("h03")) @[Fetch.scala 29:33]
    node _io_pc_out_T_2 = bits(io.inst, 6, 0) @[Fetch.scala 29:51]
    node _io_pc_out_T_3 = eq(_io_pc_out_T_2, UInt<7>("h063")) @[Fetch.scala 29:56]
    node _io_pc_out_T_4 = or(_io_pc_out_T_1, _io_pc_out_T_3) @[Fetch.scala 29:41]
    node _io_pc_out_T_5 = bits(io.inst, 6, 0) @[Fetch.scala 29:76]
    node _io_pc_out_T_6 = eq(_io_pc_out_T_5, UInt<7>("h06f")) @[Fetch.scala 29:81]
    node _io_pc_out_T_7 = or(_io_pc_out_T_4, _io_pc_out_T_6) @[Fetch.scala 29:66]
    node _io_pc_out_T_8 = bits(io.inst, 6, 0) @[Fetch.scala 29:98]
    node _io_pc_out_T_9 = eq(_io_pc_out_T_8, UInt<7>("h067")) @[Fetch.scala 29:103]
    node _io_pc_out_T_10 = or(_io_pc_out_T_7, _io_pc_out_T_9) @[Fetch.scala 29:88]
    node _io_pc_out_T_11 = mux(_io_pc_out_T_10, pc.io.pc_out, pc4.io.pc4_out) @[Fetch.scala 29:19]
    io.pc_out <= _io_pc_out_T_11 @[Fetch.scala 29:14]
    
