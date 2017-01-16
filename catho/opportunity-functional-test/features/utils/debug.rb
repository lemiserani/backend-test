# Debug Class
require 'json'
class Debug
      def initialize
        @message = ''
      end

      def debug(response)

                if $debug == 'true'
                    puts "================" 
                    puts "\n"
                    puts "HTTP REQUEST:" 
                    puts "\t HTTP Request  method: #{response.request.http_method}"
                    puts "\t HTTP Request  path  : #{response.request.last_uri}"
                    puts "\t HTTP Request  header: #{response.request.options[:headers]}"
                    puts "\t HTTP Request  body  : " 
                    puts "#{response.request.raw_body}"
                    puts "\n"
                    puts "HTTP RESPONSE:"
                    puts "\t HTTP Response body  :"      
                    if response.body != ""       
                      puts "#{JSON.pretty_generate(response)}"
                    end
                    puts "\t HTTP Response code  : #{response.code.to_s}"
                    puts $auth
                    puts "\n"
                    puts "================"
                end
        
      end

      def debug_msg(string)
        if $debug == 'true'
                puts "#{string}\n"
        end
      end

      def log_debug(path,json,response)
                $log_service.log_message( "HTTP Request  path: #{path}")              
                $log_service.log_message( "HTTP Request  body: #{json}" )           
                $log_service.log_message( "HTTP Response body: #{response}" )     
      end

end
