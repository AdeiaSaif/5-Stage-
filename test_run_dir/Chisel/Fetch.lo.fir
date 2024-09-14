circuit Fetch :
  module PC :
    input clock : Clock
    input reset : UInt<1>
    input io_imm : SInt<32>
    output io_pc_out : UInt<32>

    reg pc : UInt<32>, clock with :
      reset => (UInt<1>("h0"), pc) @[PC.scala 9:19]
    node _pc_T = asUInt(io_imm) @[PC.scala 10:21]
    node _pc_T_1 = add(pc, _pc_T) @[PC.scala 10:11]
    node _pc_T_2 = tail(_pc_T_1, 1) @[PC.scala 10:11]
    io_pc_out <= pc @[PC.scala 11:14]
    pc <= mux(reset, UInt<32>("h0"), _pc_T_2) @[PC.scala 9:19 PC.scala 9:19 PC.scala 10:7]

  module PC4 :
    input clock : Clock
    input reset : UInt<1>
    output io_pc4_out : UInt<32>

    reg pc : UInt<32>, clock with :
      reset => (UInt<1>("h0"), pc) @[PC4.scala 7:19]
    node _pc_T = add(pc, UInt<3>("h4")) @[PC4.scala 8:11]
    node _pc_T_1 = tail(_pc_T, 1) @[PC4.scala 8:11]
    io_pc4_out <= pc @[PC4.scala 9:15]
    pc <= mux(reset, UInt<32>("h0"), _pc_T_1) @[PC4.scala 7:19 PC4.scala 7:19 PC4.scala 8:7]

  module Fetch :
    input clock : Clock
    input reset : UInt<1>
    input io_imm : SInt<32>
    input io_inst : UInt<32>
    output io_inst_out : UInt<32>
    output io_pc_out : UInt<32>

    inst pc of PC @[Fetch.scala 22:20]
    inst pc4 of PC4 @[Fetch.scala 24:21]
    node _io_pc_out_T = bits(io_inst, 6, 0) @[Fetch.scala 29:28]
    node _io_pc_out_T_1 = eq(_io_pc_out_T, UInt<7>("h3")) @[Fetch.scala 29:33]
    node _io_pc_out_T_2 = bits(io_inst, 6, 0) @[Fetch.scala 29:51]
    node _io_pc_out_T_3 = eq(_io_pc_out_T_2, UInt<7>("h63")) @[Fetch.scala 29:56]
    node _io_pc_out_T_4 = or(_io_pc_out_T_1, _io_pc_out_T_3) @[Fetch.scala 29:41]
    node _io_pc_out_T_5 = bits(io_inst, 6, 0) @[Fetch.scala 29:76]
    node _io_pc_out_T_6 = eq(_io_pc_out_T_5, UInt<7>("h6f")) @[Fetch.scala 29:81]
    node _io_pc_out_T_7 = or(_io_pc_out_T_4, _io_pc_out_T_6) @[Fetch.scala 29:66]
    node _io_pc_out_T_8 = bits(io_inst, 6, 0) @[Fetch.scala 29:98]
    node _io_pc_out_T_9 = eq(_io_pc_out_T_8, UInt<7>("h67")) @[Fetch.scala 29:103]
    node _io_pc_out_T_10 = or(_io_pc_out_T_7, _io_pc_out_T_9) @[Fetch.scala 29:88]
    node _io_pc_out_T_11 = mux(_io_pc_out_T_10, pc.io_pc_out, pc4.io_pc4_out) @[Fetch.scala 29:19]
    io_inst_out <= io_inst @[Fetch.scala 28:16]
    io_pc_out <= _io_pc_out_T_11 @[Fetch.scala 29:14]
    pc.clock <= clock
    pc.reset <= reset
    pc.io_imm <= io_imm @[Fetch.scala 27:14]
    pc4.clock <= clock
    pc4.reset <= reset
