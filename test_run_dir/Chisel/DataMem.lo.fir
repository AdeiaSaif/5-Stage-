circuit DataMem :
  module DataMem :
    input clock : Clock
    input reset : UInt<1>
    input io_address : UInt<32>
    input io_data_in : SInt<32>
    input io_load_en : UInt<1>
    input io_store_en : UInt<1>
    output io_address_out : UInt<32>
    output io_data_out : SInt<32>
    output io_load_en_out : UInt<1>
    output io_store_en_out : UInt<1>

    io_address_out <= io_address @[DataMem.scala 16:17]
    io_data_out <= io_data_in @[DataMem.scala 17:14]
    io_load_en_out <= io_load_en @[DataMem.scala 18:17]
    io_store_en_out <= io_store_en @[DataMem.scala 19:18]
