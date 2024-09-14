circuit PC4 :
  module PC4 :
    input clock : Clock
    input reset : UInt<1>
    input io_pre_pc : UInt<32>
    output io_pc_out : UInt<32>

    reg pc : UInt<32>, clock with :
      reset => (UInt<1>("h0"), pc) @[PC4.scala 8:19]
    node _pc_T = add(io_pre_pc, UInt<3>("h4")) @[PC4.scala 9:18]
    node _pc_T_1 = tail(_pc_T, 1) @[PC4.scala 9:18]
    io_pc_out <= pc @[PC4.scala 10:14]
    pc <= mux(reset, UInt<32>("h0"), _pc_T_1) @[PC4.scala 8:19 PC4.scala 8:19 PC4.scala 9:7]
