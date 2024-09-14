;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit WriteBack : 
  module WriteBack : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip alu_data : SInt<32>, flip mem_data : SInt<32>, flip load_en : UInt<1>, out : SInt<32>}
    
    node _io_out_T = mux(io.load_en, io.mem_data, io.alu_data) @[WriteBack.scala 11:16]
    io.out <= _io_out_T @[WriteBack.scala 11:11]
    
