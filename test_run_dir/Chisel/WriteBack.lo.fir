circuit WriteBack :
  module WriteBack :
    input clock : Clock
    input reset : UInt<1>
    input io_alu_data : SInt<32>
    input io_mem_data : SInt<32>
    input io_load_en : UInt<1>
    output io_out : SInt<32>

    node _io_out_T = mux(io_load_en, io_mem_data, io_alu_data) @[WriteBack.scala 11:16]
    io_out <= _io_out_T @[WriteBack.scala 11:11]
