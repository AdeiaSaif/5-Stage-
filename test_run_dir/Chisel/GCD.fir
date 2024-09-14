;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit GCD : 
  module GCD : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip value1 : UInt<16>, flip value2 : UInt<16>, output : UInt<16>}
    
    node _io_output_T = add(io.value1, io.value2) @[GCD.scala 11:24]
    node _io_output_T_1 = tail(_io_output_T, 1) @[GCD.scala 11:24]
    io.output <= _io_output_T_1 @[GCD.scala 11:13]
    
