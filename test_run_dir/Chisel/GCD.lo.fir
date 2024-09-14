circuit GCD :
  module GCD :
    input clock : Clock
    input reset : UInt<1>
    input io_value1 : UInt<16>
    input io_value2 : UInt<16>
    output io_output : UInt<16>

    node _io_output_T = add(io_value1, io_value2) @[GCD.scala 11:24]
    node _io_output_T_1 = tail(_io_output_T, 1) @[GCD.scala 11:24]
    io_output <= _io_output_T_1 @[GCD.scala 11:13]
