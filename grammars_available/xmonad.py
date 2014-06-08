from dragonfly import Grammar, MappingRule

import aenea

from proxy_nicknames import Key

grammar = Grammar("xmonad", context=aenea.global_context)

mod = "w"

ion = "win "

class Basics(MappingRule):
  defaults = {
    "n": 1,
  }

  mapping = {
      ion + "term":Key(mod + "s-enter"),
      ion + "menu":Key(mod + "-p"),
      ion + "up [<n>]":Key(mod + "-k:%(n)d"),
      ion + "down [<n>]":Key(mod + "-j:%(n)d"),
      ion + "left [<n>]":Key(mod + "s-k:%(n)d"),
      ion + "right [<n>]":Key(mod + "s-j:%(n)d"),
      ion + "main":Key(mod + "-m"),
      ion + "snap":Key(mod + "-enter"),
      ion + "add":Key(mod + "-comma"),
      ion + "remove":Key(mod + "-period"),
      ion + "shrink [<n>]":Key(mod + "-h:%(n)d"),
      ion + "grow [<n>]":Key(mod + "-l:%(n)d"),
      ion + "size":Key(mod + "-n"),
      ion + "reset":Key(mod + "s-space"),
      ion + "close":Key(mod + "s-c"),
      ion + "return":Key(mod + "-t"),
      ion + "cycle [<n>]":Key(mod + "-space:%(n)d"),
      ion + "<n>":Key(mod + "-%(n)d"),
      ion + "move <n>":Key(mod + "s-%(n)d"),
      ion + "restart":Key(mod + "-q")
    }

  extras = [aenea.DigitalInteger("n", 1, None)]

grammar.add_rule(Basics())
grammar.load()

def unload():
  global grammar
  if grammar: grammar.unload()
  grammar = None
