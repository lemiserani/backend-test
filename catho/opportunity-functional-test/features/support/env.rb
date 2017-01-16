require "rspec"
require "pry"
require "httparty"
require_relative "settings/application.rb"
require 'pry-byebug'
require 'yaml'

ApplicationSettings.new.setup!
