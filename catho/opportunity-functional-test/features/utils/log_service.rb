require 'logger'


class LogService

        def initialize(type)            

                $log_file_type = $logfile_compare_skus_db_cache

                if type == "skus"       
                    $log_file_type  = $logfile_compare_skus_db_cache 
                end

                if(type == "products")  
                    $log_file_type  = $logfile_compare_products_db_cache  
                end

                if(type == "web")  
                    $log_file_type  = $logfile_web_callback  
                end

                @file = File.open($log_file_type, File::WRONLY | File::APPEND | File::CREAT)            
                @logger = Logger.new(@file)
                
                @logger.formatter = proc do |severity, datetime, progname, msg|
                        "#{datetime}: #{msg}\n"
                end
        end

        def log_message(message)            
                @logger.add(Logger::INFO) { "#{message}" }
        end

        def log_close            
                @logger.close
        end


end