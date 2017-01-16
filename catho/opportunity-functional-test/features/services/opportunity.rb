class OpportunityService
  include HTTParty

            def initialize(url_path)
                    @server  =    $opportunity_server[$env]
                    @headers =    $opportunity_headers
                    @auth    =    $opportunity_authentication[$env]    
                    @url     =    "#{@server}#{url_path}"   
            end

            def get                          
                    return   HTTParty.get( @url , :basic_auth => @auth, :headers => @headers)  
            end 

end