import os, os.path, sys
import urllib, zipfile
import shutil, glob, fnmatch
import subprocess, logging
import shutil
from optparse import OptionParser
    
def bop_main(bop_dir, mcp_dir):
    sys.path.append(mcp_dir)
    from runtime.updatemd5 import updatemd5
    from bop import decompile, apply_initial_patches, apply_bop_patches, reset_logger, copytree
    
    print '=============================== Biomes O Plenty Setup Start ====================================='

    print '-=Decompiling=-'
    decompile(mcp_dir, bop_dir)
    print ' '
    print '-=Applying patches=-'
    apply_initial_patches(mcp_dir, bop_dir, os.path.join(mcp_dir, 'src'), True)
    os.chdir(mcp_dir)
    reset_logger()
    print ''
    print '-=Update MD5=-'
    updatemd5(None, True, False, False)
    reset_logger()
    print ''
    print '-=Copy Src=-'
    copytree(os.path.join(mcp_dir, 'src'), os.path.join(mcp_dir, 'src_base')) 
    os.chdir(bop_dir)
    print ''
    print '-=Apply BoP Patches=-'
    apply_bop_patches(mcp_dir, bop_dir, os.path.join(mcp_dir, 'src'), True)  
    shutil.rmtree(os.path.join(mcp_dir, 'eclipse'))
    copytree(os.path.join(bop_dir, 'tmpworkspace'), os.path.join(mcp_dir, 'eclipse')) 
    print '=============================== Biomes O Plenty Setup Finished ================================='

if __name__ == '__main__':
    parser = OptionParser()
    parser.add_option('-m', '--mcp-dir',   action='store',      dest='mcp_dir',       help='Path to download/extract MCP to',         default=None )
    options, _ = parser.parse_args()
    
    bop_dir = os.path.dirname(os.path.abspath(__file__))
    mcp_dir = os.path.abspath('mcp')

    if not options.mcp_dir is None:
        mcp_dir = os.path.abspath(options.mcp_dir)
    
    bop_main(bop_dir, mcp_dir)