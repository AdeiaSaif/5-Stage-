;buildInfoPackage: chisel3, version: 3.4.3, scalaVersion: 2.12.12, sbtVersion: 1.3.10
circuit DataMem : 
  module DataMem : 
    input clock : Clock
    input reset : UInt<1>
    output io : {flip address : UInt<32>, flip data_in : SInt<32>, flip load_en : UInt<1>, flip store_en : UInt<1>, address_out : UInt<32>, data_out : SInt<32>, load_en_out : UInt<1>, store_en_out : UInt<1>}
    
    io.address_out <= io.address @[DataMem.scala 16:17]
    io.data_out <= io.data_in @[DataMem.scala 17:14]
    io.load_en_out <= io.load_en @[DataMem.scala 18:17]
    io.store_en_out <= io.store_en @[DataMem.scala 19:18]
    
