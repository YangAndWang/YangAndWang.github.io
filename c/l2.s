# objdump l2 > l2.s
l2：     文件格式 elf64-x86-64


Disassembly of section .init:

0000000000000530 <_init>:
 530:	48 83 ec 08          	sub    $0x8,%rsp
 534:	48 8b 05 a5 0a 20 00 	mov    0x200aa5(%rip),%rax        # 200fe0 <__gmon_start__>
 53b:	48 85 c0             	test   %rax,%rax
 53e:	74 02                	je     542 <_init+0x12>
 540:	ff d0                	callq  *%rax
 542:	48 83 c4 08          	add    $0x8,%rsp
 546:	c3                   	retq   

Disassembly of section .plt:

0000000000000550 <.plt>:
 550:	ff 35 62 0a 20 00    	pushq  0x200a62(%rip)        # 200fb8 <_GLOBAL_OFFSET_TABLE_+0x8>
 556:	ff 25 64 0a 20 00    	jmpq   *0x200a64(%rip)        # 200fc0 <_GLOBAL_OFFSET_TABLE_+0x10>
 55c:	0f 1f 40 00          	nopl   0x0(%rax)

Disassembly of section .plt.got:

0000000000000560 <.plt.got>:
 560:	ff 25 6a 0a 20 00    	jmpq   *0x200a6a(%rip)        # 200fd0 <printf@GLIBC_2.2.5>
 566:	66 90                	xchg   %ax,%ax
 568:	ff 25 8a 0a 20 00    	jmpq   *0x200a8a(%rip)        # 200ff8 <__cxa_finalize@GLIBC_2.2.5>
 56e:	66 90                	xchg   %ax,%ax

Disassembly of section .text:

0000000000000570 <_start>:
 570:	31 ed                	xor    %ebp,%ebp
 572:	49 89 d1             	mov    %rdx,%r9
 575:	5e                   	pop    %rsi
 576:	48 89 e2             	mov    %rsp,%rdx
 579:	48 83 e4 f0          	and    $0xfffffffffffffff0,%rsp
 57d:	50                   	push   %rax
 57e:	54                   	push   %rsp
 57f:	4c 8d 05 2a 02 00 00 	lea    0x22a(%rip),%r8        # 7b0 <__libc_csu_fini>
 586:	48 8d 0d b3 01 00 00 	lea    0x1b3(%rip),%rcx        # 740 <__libc_csu_init>
 58d:	48 8d 3d 47 01 00 00 	lea    0x147(%rip),%rdi        # 6db <main>
 594:	ff 15 3e 0a 20 00    	callq  *0x200a3e(%rip)        # 200fd8 <__libc_start_main@GLIBC_2.2.5>
 59a:	f4                   	hlt    
 59b:	0f 1f 44 00 00       	nopl   0x0(%rax,%rax,1)

00000000000005a0 <deregister_tm_clones>:
 5a0:	48 8d 3d 69 0a 20 00 	lea    0x200a69(%rip),%rdi        # 201010 <__TMC_END__>
 5a7:	48 8d 05 69 0a 20 00 	lea    0x200a69(%rip),%rax        # 201017 <__TMC_END__+0x7>
 5ae:	55                   	push   %rbp
 5af:	48 29 f8             	sub    %rdi,%rax
 5b2:	48 89 e5             	mov    %rsp,%rbp
 5b5:	48 83 f8 0e          	cmp    $0xe,%rax
 5b9:	76 15                	jbe    5d0 <deregister_tm_clones+0x30>
 5bb:	48 8b 05 06 0a 20 00 	mov    0x200a06(%rip),%rax        # 200fc8 <_ITM_deregisterTMCloneTable>
 5c2:	48 85 c0             	test   %rax,%rax
 5c5:	74 09                	je     5d0 <deregister_tm_clones+0x30>
 5c7:	5d                   	pop    %rbp
 5c8:	ff e0                	jmpq   *%rax
 5ca:	66 0f 1f 44 00 00    	nopw   0x0(%rax,%rax,1)
 5d0:	5d                   	pop    %rbp
 5d1:	c3                   	retq   
 5d2:	0f 1f 40 00          	nopl   0x0(%rax)
 5d6:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 5dd:	00 00 00 

00000000000005e0 <register_tm_clones>:
 5e0:	48 8d 3d 29 0a 20 00 	lea    0x200a29(%rip),%rdi        # 201010 <__TMC_END__>
 5e7:	48 8d 35 22 0a 20 00 	lea    0x200a22(%rip),%rsi        # 201010 <__TMC_END__>
 5ee:	55                   	push   %rbp
 5ef:	48 29 fe             	sub    %rdi,%rsi
 5f2:	48 89 e5             	mov    %rsp,%rbp
 5f5:	48 c1 fe 03          	sar    $0x3,%rsi
 5f9:	48 89 f0             	mov    %rsi,%rax
 5fc:	48 c1 e8 3f          	shr    $0x3f,%rax
 600:	48 01 c6             	add    %rax,%rsi
 603:	48 d1 fe             	sar    %rsi
 606:	74 18                	je     620 <register_tm_clones+0x40>
 608:	48 8b 05 e1 09 20 00 	mov    0x2009e1(%rip),%rax        # 200ff0 <_ITM_registerTMCloneTable>
 60f:	48 85 c0             	test   %rax,%rax
 612:	74 0c                	je     620 <register_tm_clones+0x40>
 614:	5d                   	pop    %rbp
 615:	ff e0                	jmpq   *%rax
 617:	66 0f 1f 84 00 00 00 	nopw   0x0(%rax,%rax,1)
 61e:	00 00 
 620:	5d                   	pop    %rbp
 621:	c3                   	retq   
 622:	0f 1f 40 00          	nopl   0x0(%rax)
 626:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 62d:	00 00 00 

0000000000000630 <__do_global_dtors_aux>:
 630:	80 3d d9 09 20 00 00 	cmpb   $0x0,0x2009d9(%rip)        # 201010 <__TMC_END__>
 637:	75 27                	jne    660 <__do_global_dtors_aux+0x30>
 639:	48 83 3d b7 09 20 00 	cmpq   $0x0,0x2009b7(%rip)        # 200ff8 <__cxa_finalize@GLIBC_2.2.5>
 640:	00 
 641:	55                   	push   %rbp
 642:	48 89 e5             	mov    %rsp,%rbp
 645:	74 0c                	je     653 <__do_global_dtors_aux+0x23>
 647:	48 8b 3d ba 09 20 00 	mov    0x2009ba(%rip),%rdi        # 201008 <__dso_handle>
 64e:	e8 15 ff ff ff       	callq  568 <.plt.got+0x8>
 653:	e8 48 ff ff ff       	callq  5a0 <deregister_tm_clones>
 658:	5d                   	pop    %rbp
 659:	c6 05 b0 09 20 00 01 	movb   $0x1,0x2009b0(%rip)        # 201010 <__TMC_END__>
 660:	f3 c3                	repz retq 
 662:	0f 1f 40 00          	nopl   0x0(%rax)
 666:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 66d:	00 00 00 

0000000000000670 <frame_dummy>:
 670:	48 8d 3d 71 07 20 00 	lea    0x200771(%rip),%rdi        # 200de8 <__JCR_END__>
 677:	48 83 3f 00          	cmpq   $0x0,(%rdi)
 67b:	75 0b                	jne    688 <frame_dummy+0x18>
 67d:	e9 5e ff ff ff       	jmpq   5e0 <register_tm_clones>
 682:	66 0f 1f 44 00 00    	nopw   0x0(%rax,%rax,1)
 688:	48 8b 05 59 09 20 00 	mov    0x200959(%rip),%rax        # 200fe8 <_Jv_RegisterClasses>
 68f:	48 85 c0             	test   %rax,%rax
 692:	74 e9                	je     67d <frame_dummy+0xd>
 694:	55                   	push   %rbp
 695:	48 89 e5             	mov    %rsp,%rbp
 698:	ff d0                	callq  *%rax
 69a:	5d                   	pop    %rbp
 69b:	e9 40 ff ff ff       	jmpq   5e0 <register_tm_clones>

00000000000006a0 <p1>:
#include<stdio.h>

void p1(char c){
 6a0:	55                   	push   %rbp
 6a1:	48 89 e5             	mov    %rsp,%rbp
 6a4:	48 83 ec 10          	sub    $0x10,%rsp
 6a8:	89 f8                	mov    %edi,%eax
 6aa:	88 45 fc             	mov    %al,-0x4(%rbp)
  printf("%c\n", c);
 6ad:	0f be 45 fc          	movsbl -0x4(%rbp),%eax
 6b1:	89 c6                	mov    %eax,%esi
 6b3:	48 8d 3d 0a 01 00 00 	lea    0x10a(%rip),%rdi        # 7c4 <_IO_stdin_used+0x4>
 6ba:	b8 00 00 00 00       	mov    $0x0,%eax
 6bf:	e8 9c fe ff ff       	callq  560 <.plt.got>
}
 6c4:	90                   	nop
 6c5:	c9                   	leaveq 
 6c6:	c3                   	retq   

00000000000006c7 <p2>:

int p2(int x,int y){
 6c7:	55                   	push   %rbp
 6c8:	48 89 e5             	mov    %rsp,%rbp
 6cb:	89 7d fc             	mov    %edi,-0x4(%rbp)
 6ce:	89 75 f8             	mov    %esi,-0x8(%rbp)
  return x + y;
 6d1:	8b 55 fc             	mov    -0x4(%rbp),%edx
 6d4:	8b 45 f8             	mov    -0x8(%rbp),%eax
 6d7:	01 d0                	add    %edx,%eax
}
 6d9:	5d                   	pop    %rbp
 6da:	c3                   	retq   

00000000000006db <main>:
int main(){
 6db:	55                   	push   %rbp
 6dc:	48 89 e5             	mov    %rsp,%rbp
 6df:	48 83 ec 10          	sub    $0x10,%rsp
  char c = 'a';
 6e3:	c6 45 f3 61          	movb   $0x61,-0xd(%rbp)
  int x,y,z;
  x = 1;
 6e7:	c7 45 f4 01 00 00 00 	movl   $0x1,-0xc(%rbp)
  y = 2;
 6ee:	c7 45 f8 02 00 00 00 	movl   $0x2,-0x8(%rbp)
  p1(c);
 6f5:	0f be 45 f3          	movsbl -0xd(%rbp),%eax
 6f9:	89 c7                	mov    %eax,%edi
 6fb:	e8 a0 ff ff ff       	callq  6a0 <p1>
  z = p2(x,y);
 700:	8b 55 f8             	mov    -0x8(%rbp),%edx
 703:	8b 45 f4             	mov    -0xc(%rbp),%eax
 706:	89 d6                	mov    %edx,%esi
 708:	89 c7                	mov    %eax,%edi
 70a:	e8 b8 ff ff ff       	callq  6c7 <p2>
 70f:	89 45 fc             	mov    %eax,-0x4(%rbp)
  printf("%d + %d = %d\n",x,y,z);
 712:	8b 4d fc             	mov    -0x4(%rbp),%ecx
 715:	8b 55 f8             	mov    -0x8(%rbp),%edx
 718:	8b 45 f4             	mov    -0xc(%rbp),%eax
 71b:	89 c6                	mov    %eax,%esi
 71d:	48 8d 3d a4 00 00 00 	lea    0xa4(%rip),%rdi        # 7c8 <_IO_stdin_used+0x8>
 724:	b8 00 00 00 00       	mov    $0x0,%eax
 729:	e8 32 fe ff ff       	callq  560 <.plt.got>
 72e:	b8 00 00 00 00       	mov    $0x0,%eax
}
 733:	c9                   	leaveq 
 734:	c3                   	retq   
 735:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 73c:	00 00 00 
 73f:	90                   	nop

0000000000000740 <__libc_csu_init>:
 740:	41 57                	push   %r15
 742:	41 56                	push   %r14
 744:	41 89 ff             	mov    %edi,%r15d
 747:	41 55                	push   %r13
 749:	41 54                	push   %r12
 74b:	4c 8d 25 86 06 20 00 	lea    0x200686(%rip),%r12        # 200dd8 <__frame_dummy_init_array_entry>
 752:	55                   	push   %rbp
 753:	48 8d 2d 86 06 20 00 	lea    0x200686(%rip),%rbp        # 200de0 <__init_array_end>
 75a:	53                   	push   %rbx
 75b:	49 89 f6             	mov    %rsi,%r14
 75e:	49 89 d5             	mov    %rdx,%r13
 761:	4c 29 e5             	sub    %r12,%rbp
 764:	48 83 ec 08          	sub    $0x8,%rsp
 768:	48 c1 fd 03          	sar    $0x3,%rbp
 76c:	e8 bf fd ff ff       	callq  530 <_init>
 771:	48 85 ed             	test   %rbp,%rbp
 774:	74 20                	je     796 <__libc_csu_init+0x56>
 776:	31 db                	xor    %ebx,%ebx
 778:	0f 1f 84 00 00 00 00 	nopl   0x0(%rax,%rax,1)
 77f:	00 
 780:	4c 89 ea             	mov    %r13,%rdx
 783:	4c 89 f6             	mov    %r14,%rsi
 786:	44 89 ff             	mov    %r15d,%edi
 789:	41 ff 14 dc          	callq  *(%r12,%rbx,8)
 78d:	48 83 c3 01          	add    $0x1,%rbx
 791:	48 39 dd             	cmp    %rbx,%rbp
 794:	75 ea                	jne    780 <__libc_csu_init+0x40>
 796:	48 83 c4 08          	add    $0x8,%rsp
 79a:	5b                   	pop    %rbx
 79b:	5d                   	pop    %rbp
 79c:	41 5c                	pop    %r12
 79e:	41 5d                	pop    %r13
 7a0:	41 5e                	pop    %r14
 7a2:	41 5f                	pop    %r15
 7a4:	c3                   	retq   
 7a5:	90                   	nop
 7a6:	66 2e 0f 1f 84 00 00 	nopw   %cs:0x0(%rax,%rax,1)
 7ad:	00 00 00 

00000000000007b0 <__libc_csu_fini>:
 7b0:	f3 c3                	repz retq 

Disassembly of section .fini:

00000000000007b4 <_fini>:
 7b4:	48 83 ec 08          	sub    $0x8,%rsp
 7b8:	48 83 c4 08          	add    $0x8,%rsp
 7bc:	c3                   	retq   
