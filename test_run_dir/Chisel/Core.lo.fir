circuit Core :
  module PC4 :
    input clock : Clock
    input reset : UInt<1>
    input io_pre_pc : SInt<32>
    output io_pc_out : SInt<32>

    reg pc : SInt<32>, clock with :
      reset => (UInt<1>("h0"), pc) @[PC4.scala 8:19]
    node _pc_T = add(io_pre_pc, asSInt(UInt<4>("h4"))) @[PC4.scala 9:18]
    node _pc_T_1 = tail(_pc_T, 1) @[PC4.scala 9:18]
    node _pc_T_2 = asSInt(_pc_T_1) @[PC4.scala 9:18]
    io_pc_out <= pc @[PC4.scala 10:14]
    pc <= mux(reset, asSInt(UInt<32>("h0")), _pc_T_2) @[PC4.scala 8:19 PC4.scala 8:19 PC4.scala 9:7]

  module Core :
    input clock : Clock
    input reset : UInt<1>

    inst pc4 of PC4 @[Core.scala 9:21]
    pc4.clock <= clock
    pc4.reset <= reset
    pc4.io_pre_pc <= asSInt(UInt<1>("h0")) @[Core.scala 11:18]
